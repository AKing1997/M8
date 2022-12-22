package es.kankit.camkit.DB

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import es.kankit.camkit.Criptomoneda
import es.kankit.camkit.DB.DB.Criptomonedas.COLUMN_DIRECCION
import es.kankit.camkit.DB.DB.Criptomonedas.COLUMN_ID
import es.kankit.camkit.DB.DB.Criptomonedas.COLUMN_NAME
import es.kankit.camkit.DB.DB.Criptomonedas.COLUMN_TYPE
import es.kankit.camkit.DB.DB.Criptomonedas.SQL_CREATE_TABLE
import es.kankit.camkit.DB.DB.Criptomonedas.SQL_DELETE_ENTRIES
import es.kankit.camkit.DB.DB.Criptomonedas.TABLE_NAME

class DBHelper(c: Context): SQLiteOpenHelper(c, DATABASE_NAME,null , DATABASE_VERSION) {
    var context:Context=c;// variable que contiene contexto o sea mas o menos el view
    // Creando la tabla
    override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(SQL_CREATE_TABLE);
    }

    // crando funcion upgrade para eliminar la tabla si existe
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
    }
    // Declarando variable globales
    companion object {
            const val DATABASE_VERSION = 2;
            const val DATABASE_NAME = "criptos.db";
    }
    // Creando la funcion eliminar criptomoneda
    fun deleteCrypto(num: Int){
        val db = this.writableDatabase;
        db.execSQL("delete from ${TABLE_NAME} where id= ${num}")
        Toast.makeText(context, "Se ha eliminado correctamente",Toast.LENGTH_SHORT).show();
    }
    // Creando la funcion para eliminar la tabla
    fun deleteAllCryptos(){
        val db = this.writableDatabase;
        db.delete(TABLE_NAME,null,null);
        Toast.makeText(context, "Se ha eliminado correctamente",Toast.LENGTH_SHORT).show();
    }
    // Funcion que para insertar criptomoneda en la base de datos
    fun insertCriptomoneda(c: Criptomoneda) {
        val values = ContentValues();
        values.put(COLUMN_NAME, c.name);
        values.put(COLUMN_TYPE, c.type);
        values.put(COLUMN_DIRECCION, c.hash);

        val db = this.writableDatabase;
        db.insert(TABLE_NAME, null, values);
        Toast.makeText(context, "Se ha añadido correctamente",Toast.LENGTH_SHORT).show();
    }
    // funcion para obtener todas las criptomones que exite en base de datos
    @SuppressLint("Range")
    fun getListaCriptos(): ArrayList<Criptomoneda>{
        val array: ArrayList<Criptomoneda> = ArrayList();
        val datab = this.readableDatabase;
        val criptos: Cursor = datab.rawQuery("SELECT * FROM $TABLE_NAME", null);
        if(criptos.moveToFirst()){
            do {
                val id: Int = criptos.getInt(criptos.getColumnIndex(COLUMN_ID));
                val nom:String = criptos.getString(criptos.getColumnIndex(COLUMN_NAME));
                val tipo:String = criptos.getString(criptos.getColumnIndex(COLUMN_TYPE));
                val direccion:String = criptos.getString(criptos.getColumnIndex(COLUMN_DIRECCION));
                array.add(Criptomoneda(id,nom,tipo,direccion));
            }while (criptos.moveToNext())
        }
        return array;
    }

}