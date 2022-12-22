package es.kankit.camkit.DB
// Creando varibale objetos
class DB {
    object Criptomonedas{
        val TABLE_NAME ="criptos";
        val COLUMN_ID ="id";
        val COLUMN_NAME ="nombre";
        val COLUMN_TYPE ="tipo";
        val COLUMN_DIRECCION ="direccion";
        val SQL_CREATE_TABLE = "CREATE TABLE ${TABLE_NAME} (${COLUMN_ID} INTEGER PRIMARY KEY, ${COLUMN_NAME} TEXT,${COLUMN_TYPE} TEXT,${COLUMN_DIRECCION} TEXT)";
        val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}";
    }
}