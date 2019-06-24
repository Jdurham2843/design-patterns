package structural

/**
 *  Types of proxies:
 *  1. Remote Proxy - This will provide a local representative to an object in a different address space
 *  2. Virtual Proxy - Used to create expensive objects on demand
 *  3. Protection Proxy - Used to provide access control to objects
 *  4. Smart references (applicable in lower level languages) - can be used to note the references to a given object.
 */

class Wizard(val name: String) {

    override fun toString(): String {
        return name
    }
}

interface WizardTower {
    fun enter(wizard: Wizard)
}

class IvoryTower : WizardTower {

    override fun enter(wizard: Wizard) {
        println("$wizard has entered the tower")
    }
}

class WizardTowerProxy(val wizardTower: WizardTower) : WizardTower {
    private var numWizards = 0

    override fun enter(wizard: Wizard) {
        if (numWizards < NUM_WIZARDS_ALLOWED) {
            wizardTower.enter(wizard)
            numWizards++
        } else {
            println("$wizard is not allowed to enter!")
        }
    }

    companion object {
        val NUM_WIZARDS_ALLOWED = 3
    }
}

fun doProxy() {
    val proxy = WizardTowerProxy(IvoryTower())

    proxy.enter(Wizard("Red Wizard"))
    proxy.enter(Wizard("White Wizard"))
    proxy.enter(Wizard("Black Wizard"))
    proxy.enter(Wizard("Green Wizard"))
    proxy.enter(Wizard("Brown Wizard"))
}
