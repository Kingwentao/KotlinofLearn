package ClassesAndObject

interface InputDevice {
    fun input(event: Any)
}

//蓝牙输入接口
interface BLEInputDevice: InputDevice
//USB输入接口
interface USBInputDevice: InputDevice


class USBMouse(val name: String): USBInputDevice{
    override fun input(event: Any) {

    }

    override fun toString(): String {
        return name
    }
}



//电脑类
class Computer {
    fun addUSBInputDevice(inputDevice: USBInputDevice){
        println("add USB Input Device $inputDevice")
    }

    fun addBLEInputDevice(inputDevice: BLEInputDevice){
        println("add Bluetooth Input Device")
    }

    fun addInputDevices(inputDevice: InputDevice){
        when(inputDevice){
            is BLEInputDevice -> {
                addBLEInputDevice(inputDevice)
            }
            is USBInputDevice -> {
                addUSBInputDevice(inputDevice)
            }
            else -> {
                throw IllegalArgumentException("不支持该类型的输入设备")
            }

        }
    }
}


fun main() {
    val computer = Computer()
    val mouse = USBMouse("罗技鼠标")
    computer.addInputDevices(mouse)

    var child = Child()
    child.foo()  //print 29

    var d = D()
    d.foo()
    d.bar()
}


interface MyInterface {
    val prop: Int  // abstract

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        println(prop)
    }
}

class Child : MyInterface {
    override val prop: Int = 29
}

interface Named {
    val name: String
}


//继承接口
interface Person : Named {
    val firstName: String
    val lastName: String
    override val name: String
        get() = "$firstName $lastName"
}



interface A {
    fun foo() { println("A") }
    fun bar()
}

interface B {
    fun foo() { println("B") }
    fun bar() { println("B of bar") }
}


class C : A {
    override fun bar() { println("C of bar") }
}

class D: A,B{

    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }

}