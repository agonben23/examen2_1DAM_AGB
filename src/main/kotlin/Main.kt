import kotlin.math.pow
import kotlin.math.sqrt

class Punto(val id: String){ //Crea la clase Punto
    var x: Int = 0 //Crea la variable x y la inicializa
    var y: Int = 0 //Crea la variable y y la inicializa
    constructor(id: String,x1: Int,y1:Int) : this(id){ //Crea un constructor de la clase Punto, introduciendo como parámetro x e y
        x = x1
        y = y1
    }
    fun obtenerCoordenadas(): Pair<Int,Int>{ //Devuelve un Pair con las coordenadas x e y del punto
        return Pair(x,y)
    }

    override fun toString(): String { //Devuelve un string con la información del punto
        return "punto $id -> [$x,$y]"
    }

    companion object{
        fun componenteDeVector(p1: Punto,p2: Punto): Punto{ //Devuelve el punto resultante de restar otros dos puntos
            return Punto("${p1.id}${p2.id}",p2.x - p1.x,p2.y - p1.y)
        }

        fun distancia(p1: Punto,p2: Punto):Double{ //Devuelve la distancia entre dos puntos
            return sqrt((p2.x - p1.x).toDouble().pow(2.0) + (p2.y - p1.y).toDouble().pow(2.0))
        }

        fun localizacionGeograficaNS(arrayPuntos: Array<Punto>): Map<String,List<Punto>>{ //Devuelve un mapa que clasifica los puntos geográficamente, en Norte y Sur
            val lisNorte = mutableListOf<Punto>()
            val lisSur = mutableListOf<Punto>()
            arrayPuntos.forEach {
                if (it.y >= 0){
                    lisNorte.add(it)
                }else
                    lisSur.add(it)
            }
            return mapOf("Norte" to lisNorte,"Sur" to lisSur)
        }
    }
}


fun main(){
    val p1 = Punto("p1",4,2)
    val p2 = Punto("p2",7,-2)
    val p3 = Punto("p3",5,2)
    val p4 = Punto.componenteDeVector(p1,p2)

    println(p3.toString())
    println(Punto.distancia(p1,p3))
    imprimirLG(arrayOf(p1,p2,p3,p4))
}
fun imprimirLG(arrayPuntos: Array<Punto>){ //Imprime por pantalla el resultado de la función localizacionGeograficaNS
    println("Localización Geográfica NS: ${Punto.localizacionGeograficaNS(arrayPuntos)}")
}