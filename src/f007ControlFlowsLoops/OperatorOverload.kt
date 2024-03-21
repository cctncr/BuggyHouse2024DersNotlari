package f007ControlFlowsLoops

data class Vector(val numberOne: Int, val numberTwo: Int) {
    operator fun plus(vector: Vector): Vector {
        return Vector(
            numberOne + vector.numberOne,
            numberTwo + vector.numberTwo
        )
    }

    operator fun minus(vector: Vector): Vector {
        return Vector(
            numberOne - vector.numberOne,
            numberTwo - vector.numberTwo
        )
    }

    operator fun unaryMinus(): Vector {
        return Vector(-numberOne, -numberTwo)
    }

    override fun toString(): String {
        return "$numberOne:$numberTwo"
    }
}

fun main() {
    val vector1 = Vector(10, 20)
    val vector2 = Vector(5, 10)
    val vector3 = vector1 + vector2
    println(vector3)
    val vector4 = vector3 - vector2
    println(vector4)
    println(-vector4)
}