/* https://www.dofactory.com/net/builder-design-pattern */

fun runBuilder() {
   val builder1 = ConcreteBuilder1()
   val builder2 = ConcreteBuilder2()

   Director.construct(builder1)
   val p1 = builder1.getResult()
   p1.show()

   Director.construct(builder2)
   val p2 = builder2.getResult()
   p2.show()
}

// Originally this would be a class, but I would think this could also just be a static method call
object Director {
   fun construct(builder: Builder) {
      builder.buildPartA()
      builder.buildPartB()
   }
}

interface Builder {
   fun buildPartA()
   fun buildPartB()
   fun getResult() : Product
}

class ConcreteBuilder1 : Builder {

   private val product = Product()

   override fun buildPartA() {
       product.add("PartA")
   }

   override fun buildPartB() {
       product.add("PartB")
   }

   override fun getResult() : Product {
       return product
   }
}

class ConcreteBuilder2 : Builder {
   private val product = Product()

   override fun buildPartA() {
       product.add("PartX")
   }

   override fun buildPartB() {
       product.add("PartY")
   }

   override fun getResult(): Product {
       return product
   }
}

class Product {
   private val parts = ArrayList<String>()

   fun add(part: String) {
      parts.add(part)
   }

   fun show() {
      System.out.println("\nProduct Parts: ")
      parts.forEach {
         System.out.println(it)
      }
   }
}


