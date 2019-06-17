package creational

// https://java-design-patterns.com/patterns/factory-method/

enum class WeaponType {
    Spear,
    Axe;
}

abstract class Weapon(protected val weaponType: WeaponType) {
}

class ElfWeapon(weaponType: WeaponType) : Weapon(weaponType)

class OrcWeapon(weaponType: WeaponType) : Weapon(weaponType)

interface Blacksmith {
    fun manufactureWeapon(weaponType: WeaponType) : Weapon
}

class ElfBlacksmith : Blacksmith {
    override fun manufactureWeapon(weaponType: WeaponType): ElfWeapon {
        return ElfWeapon(weaponType)
    }
}

class OrcBlacksmith: Blacksmith {
    override fun manufactureWeapon(weaponType: WeaponType): OrcWeapon {
        return OrcWeapon(weaponType)
    }

}

fun runFactoryMethodExample() {
    val blacksmith = ElfBlacksmith()

    blacksmith.manufactureWeapon(WeaponType.Axe)
    blacksmith.manufactureWeapon(WeaponType.Spear)
}