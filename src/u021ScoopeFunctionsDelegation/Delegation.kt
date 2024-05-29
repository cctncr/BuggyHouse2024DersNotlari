package u021ScoopeFunctionsDelegation

interface Printer {
    fun printDocument()
}

open class InkPrinter : Printer {
    override fun printDocument() {
        println("Ink")
    }
}

class LaserPrinter : Printer {
    override fun printDocument() {
        println("Laser")
    }
}

class MixedPrinter : Printer {
    override fun printDocument() {
        println("Mixed")
    }
}

enum class PrinterType {
    INK,
    LASER,
    MIXED
}

class DocumentPrinter(printerType: PrinterType) {
    private val printer = when (printerType) {
        PrinterType.INK -> InkPrinter()
        PrinterType.LASER -> LaserPrinter()
        PrinterType.MIXED -> MixedPrinter()
    }

    fun printDocument() {
        printer.printDocument()
    }
}

// Arkaplanda Printer nesnesi olusturur bizim manuel yapmamiza gerek kalmaz
class PrinterWithDelegation(printer: Printer) : Printer by printer

fun main() {
    val inkDocumentPrinter = DocumentPrinter(PrinterType.INK)
    inkDocumentPrinter.printDocument()

    val laserDocumentPrinter = DocumentPrinter(PrinterType.LASER)
    laserDocumentPrinter.printDocument()

    val mixedDocumentPrinter = DocumentPrinter(PrinterType.MIXED)
    mixedDocumentPrinter.printDocument()

    println("<------------- With Delegation ------------->")
    val inkPrinter = InkPrinter() // bu uretim kismi dependency injection'dan gelecegi icin dert olmayacak
    val printerWithDelegation = PrinterWithDelegation(inkPrinter) // PrinterWithDelegation class'i gereksiz buyumuyor
    printerWithDelegation.printDocument()
}