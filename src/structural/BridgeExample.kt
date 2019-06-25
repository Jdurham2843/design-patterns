package structural

/**
 * https://java-design-patterns.com/patterns/bridge/
 *
 * This pattern is used to decouple an abstraction from its implementation.
 *
 * This pattern favors composition over inheritance
 */

interface Weapon {
    fun wield()
    fun swing()
    fun unwield()
    fun getEnchantment(): Enchantment
}

class Sword(private val enchantment: Enchantment): Weapon {
    override fun wield() {
        println("The sword is wielded.")
        enchantment.onActivate()
    }

    override fun swing() {
        println("The sword is swung.")
        enchantment.apply()
    }

    override fun unwield() {
        println("The sword is unwielded.")
        enchantment.onDeactivate()
    }

    override fun getEnchantment(): Enchantment {
        return enchantment
    }
}

class Hammer(private val enchantment: Enchantment) : Weapon {
    override fun wield() {
        println("The hammer is wielded.")
        enchantment.onActivate()
    }

    override fun swing() {
        println("The hammer is swung.")
        enchantment.apply()
    }

    override fun unwield() {
        println("The hammer is unwielded.")
        enchantment.onDeactivate()
    }

    override fun getEnchantment(): Enchantment {
        return enchantment
    }
}

interface Enchantment {
    fun onActivate()
    fun apply()
    fun onDeactivate()
}

class FlyingEnchantment : Enchantment {
    override fun onActivate() {
        println("The item begins to glow faintly.")
    }

    override fun apply() {
        println("The item flies and strikes the enemies finally returning to the owner's hand.")
    }

    override fun onDeactivate() {
        println("The item's glow fades.")
    }
}

class SoulEatingEnchantment : Enchantment {
    override fun onActivate() {
        println("The item spreads bloodlust.")
    }

    override fun apply() {
        println("The item eats the soul of its enemies.")
    }

    override fun onDeactivate() {
        println("Bloodlust slowly disappears.")
    }
}

fun runBridge() {
    val enchantedWeapons = listOf<Weapon>(Sword(SoulEatingEnchantment()), Hammer(FlyingEnchantment()))

    enchantedWeapons.forEach {
        it.wield()
        it.swing()
        it.unwield()
    }
}
