interface ContinentFactory {
    fun createHerbivore() : Herbivore
    fun createCarnivore() : Carnivore
}

interface Herbivore {

}

interface Carnivore {
    fun eat(h: Herbivore)
}

class AfricaFactory: ContinentFactory {
    override fun createHerbivore(): Herbivore {
        return Wildebeest()
    }

    override fun createCarnivore(): Carnivore {
        return Lion()
    }
}

class Wildebeest : Herbivore

class Lion : Carnivore {
    override fun eat(h: Herbivore) {
        System.out.println(javaClass.name + " eats " + h.javaClass.name)
    }
}

class AmericaFactory: ContinentFactory {
    override fun createHerbivore(): Herbivore {
        return Bison()
    }

    override fun createCarnivore(): Carnivore {
        return Wolf()
    }
}

class Bison : Herbivore

class Wolf : Carnivore {
    override fun eat(h: Herbivore) {
        System.out.println(javaClass.name + " eats " + h.javaClass.name)
    }
}

fun animalWorld(continentFactory: ContinentFactory) {
    val carnivore = continentFactory.createCarnivore()
    val herbivore = continentFactory.createHerbivore()

    carnivore.eat(herbivore)
}

fun run() {
    val factoryList = listOf<ContinentFactory>(AmericaFactory(), AfricaFactory())

    factoryList.forEach { animalWorld(it) }
}

