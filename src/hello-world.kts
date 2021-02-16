import java.util.*


println(sayHello("Raja"))
fun sayHello(name: String): String {
    return "Hello $name"
}


val helloString: String = sayHello("Raja")
println(helloString + helloString.length)

var helloString1 = sayHello("Raja")
println(helloString1 + helloString1.length)

helloString1 = sayHello("Ram")
println(helloString1 + helloString1.length)

println(sayHelloDefault())
fun sayHelloDefault(name: String = "World") = "Hello $name"

val hello: String = """
    hello world
                how are you doing?
""".trimMargin().trimIndent()
println(hello)

println(sayHelloMayBeNull()?.length ?: 0)
println(sayHelloMayBeNull(null)?.length ?: 0)
println(sayHelloMayBeNull("Raja")?.length ?: 0)
fun sayHelloMayBeNull(name: String? = "World"): String? {
    println(name?.length ?: 0)
    if (name == "Raja") {
        return "Hello $name"
    }
    return null
}

println(multiParameters(name = "John", weight = 120, age = 15))
fun multiParameters(name: String, age: Int, weight: Int): String {
    return "$name Age: $age weight: $weight"
}

for (i in 1 until 10 step 2) {
    println(i)
}

val values = listOf("Raja", "Ram", "Rajaram")
for ((i, value) in values.withIndex()) {
    println("$value $i")
}

println(anyTypeParam(arg = 1))
println(anyTypeParam(arg = 2))
println(anyTypeParam(arg = "Raja"))
println(anyTypeParam(arg = 1.1))
fun anyTypeParam(arg: Any): String = when (arg) {
    1 -> "one"
    in 1..9 -> "less than 10"
    is String -> "Got a String with length ${arg.length}"
    else -> "something else"
}


println(nullableParamLength(arg = "Hello"))
println(nullableParamLength(arg = null))
fun nullableParamLength(arg: String?) = when (arg) {
    null -> "Null passed"
    else -> "${arg.length}"
}

println(nullableParamLengthList(values))
println(nullableParamLengthList(emptyList()))
fun nullableParamLengthList(arg: List<String>?) = when (arg) {
    null -> "Null passed"
    args -> "empty array" //TODO: ****************************************** have to check for empty collection
    else -> "${arg.size}"
}

println(getInt())
fun getInt(): Int = when (Math.random() > 0.5) {
    true -> 1
    false -> 0// can't be null primitive
}

values.forEach(::println)
values.forEach { println(it) }
values.forEach { it -> println(it) }

//Extension Methods

fun String.sayHelloString() = "Hello  ${this}"

println("Raja".sayHelloString())


class Car(val year: Int, var color: String, make: String) {
    var model = when (make) {
        "Dodge" -> "Charger"
        "Honda" -> "Civic"
        else -> "unknown"
    }
        get() = field + year
}

val car = Car(2019, "Blue", "Honda")
println(car.year)
println(car.color)
println(car.model)
car.color = "Yellow"
//car.year = 2020// Can't do
//println(car.make)
println(car.year)
println(car.color)
println(car.model)

//Companion object

//Properties
println(car)
data class CarData(val year: Int, val make: String, val model: String)

println(CarData(2019, "Honda", "Civic"))


//infix
class InfixTest {
    infix fun testInfixHello(name: String) = "Hello $name"
}
println(InfixTest() testInfixHello "Raja")


val greet: String.(String) -> String = { it -> "$this $it" }

println(greet("Hello", "Raja"))



class App {
    var numStream = Arrays.asList(1, 2, 3).stream()
}

val app: App = App()
app.numStream.forEach(System.out::println)
if (Math.random() > 0.5) {
    app.numStream = Arrays.asList(4, 5, 6).stream()
}
//app.numStream.forEach(System.out::println)


fun rotateMatrix(matrix: Array<Array<Int>>) {
    val len = matrix.size / 2
    for(layer in 0 until len-1){
        val start = layer
        val end = matrix.size -1 -start
        println()
        println("$start - $end")
    }
}
rotateMatrix(
    arrayOf(
        arrayOf(1, 2, 3, 4, 5),
        arrayOf(6, 7, 8, 9, 10),
        arrayOf(11, 12, 13, 14, 15),
        arrayOf(16, 17, 18, 19, 20),
        arrayOf(21, 22, 23, 24, 25)
    )
)