package es.kankit.camkit
// Creando accesos "getter y setters de repativos variables junto con toString"
class Criptomoneda(var id: Int,var name: String,
var type: String,
var hash: String) {
    @JvmName("getId1")
    fun getId(): Int {
        return this.id
    }

    @JvmName("setId1")
    fun setId(id: Int){
        this.id = id
    }

    @JvmName("getName1")
    fun getName(): String {
        return this.name
    }

    @JvmName("setName1")
    fun setName(name:String){
        this.name = name
    }

    @JvmName("getType1")
    fun getType(): String {
        return this.type
    }

    @JvmName("setType1")
    fun setType(type: String) {
        this.type = type
    }
    @JvmName("getHash1")
    fun getHash(): String {
        return this.hash
    }

    @JvmName("setHash1")
    fun setHash(hash:String){
        this.hash = hash
    }

    override fun toString(): String {
        return "Criptomoneda(Name='$name', Type='$type', Hash='$hash')"
    }


}