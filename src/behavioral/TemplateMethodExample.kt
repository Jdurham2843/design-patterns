package behavioral

// https://java-design-patterns.com/patterns/template-method/

internal abstract class BookWriter(protected val name: String) {
    protected abstract fun consumeCaffeine()

    protected abstract fun writeBook()

    private fun publishBook() {
        println("$name is sending book to publisher")
    }
    fun write() {
        consumeCaffeine()
        writeBook()
        publishBook()
    }
}

internal class IntuitiveBookWriter(name: String = "Intuitive Writer") : BookWriter(name) {
    override fun consumeCaffeine() {
        println("$name drinks a cup of tea.")
    }

    override fun writeBook() {
        println("$name begins writing without a planning phase")
    }
}

internal class ArchitectBookWriter(name: String = "Architect Writer") : BookWriter(name) {
    override fun consumeCaffeine() {
        println("$name drinks a cup of coffee.")
    }

    override fun writeBook() {
        println("$name makes an outline, then writes the book.")
    }

}

fun runTemplateMethod() {
    val writers = listOf(IntuitiveBookWriter(), ArchitectBookWriter())
    writers.forEach { it.write() }
}