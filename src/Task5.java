Реализуйте иерархию классов с примером основных принципов ООП. По возможности укажите, где какой принцип используется.
За основу возьмите роботов. 

Робот умеет ходить, ездить или летать.
Робот имеет тип назначения:
* боевой робот снабжён набором оружия (стрелкового или мечом) и умеет стрелять;
* сварщик сваривает детали;
* повар готовит.

Роботы заправляются по определённому циклу в зависимости от вида энергии:
* атомной раз в 50 лет;
* внутреннего сгорания (дизельное топливо, бензин) по мере опустошения бака в зависимости от его объёма;
* электрической по мере уменьшению заряда до 20%.

Продемонстрируйте, пожалуйста:
* роботов по каждому виду назначения с каждым видом топлива (3*3 = 9 объектов);
* работу каждого робота;
* заправку каждого робота по его запросу.

Негативная проверка:
* хотя бы один робот использован не по назначению;
* хотя бы один робот заправлен не тем топливом.

// описания интерфейсов:
// декларация метода без имплементации
interface Ihand{       // 
    function attack() {}   // атака в целом, не разбивал на типы, упростил
    function welding() {}   // сваривает детали
    function cook() {}   // готовит еду
    }

interface IEnergyGenerator{   // методы, реализующие классы заправки
    function uranium_rod() {} // атомная энергия
    function fuel() {}   // топливо
    function generate_energy() {} // электрический, батарейка или генератор
}

interface IMove{             // методы, реализующие классы движения
    function walk() {}       // ходит
    function drive() {}      // ездит
    function fly() {}        // летает
}

// классы, реализующие интерфейсы:

class LaserGun() : Ihand
{
    function attack(){ 
        // имплементация запуска cтрельбы
    }
}

class Slash() : Ihand
{
    function attack(){
        // имплементация удара мечом
    }
}

class scv() : Ihand
{
    function welding(){
        // имплементация сваривания 
    }
}

class chef() : Ihand
{
    function cook(){
        // имплементация готовки
    }
}

class NuclearReactor() : IEnergyGenerator
{
    function uranium_rod(){
        // генерация энергии от урановых стержней
    }
    function add(){
        // имплементация загрузки урановых стержней
    }
}   

class gasstation() : IEnergyGenerator
{
    function fuel(){
        // генерация энергии от топлива сгорания
    }
    function add(){
        // имплементация загрузки топлива сгорания
    }
}

class battery() : IEnergyGenerator
{
    function generate_energy(){
        // генерация энергии в аккумуляторе робота
    }
    function add(){
        // имплементация энергии в аккумулятор робота
    }
}

class walking() : Iwalk
{
    function walk(){
        // имплементация использования метода передвижения - ходит
    }   
}

class driving() : Iwalk
{
    function drive(){
        // имплементация использования метода передвижения - ездит
    }
}

class flying() : Iwalk
{
    function fly(){
        // имплементация использования метода передвижения - летает
    }
}

// класс - потребитель:

class Robot() {
    //  композиция: 
    Ihand slot_hand  // Интерфейсы указаны в качестве типов данных.
    IEnergyGenerator slot_energy_generator // Они могут принимать любые объекты,
    Iwalk slot_walk // которые имплементируют указанный интерфейс
    
    /*
    в параметрах методов интерфейс тоже указан как тип данных,
    метод может принимать объект любого класса,
    имплементирующий данный интерфейс:
    */
    function install_hand(Ihand hand){ 
        this.slot_hand = hand
    }
    
    function install_energy_generator(IEnergyGenerator energy_generator){
        this.slot_energy_generator = energy_generator
    }
    
    function install_walk(Iwalk walk){
        this.slot_walk = walk
    }
}

// далее 9 видов роботов, с установленным оборудованием
// перебор классов 3 вида того что робот держит в руке и 3 х способов питания
// способ передвижения опускаем для сокращения количества классов, считаем что не важен для выполнения задач
// т.к если включить сюда и зависимость от вида передвижения, то получится 27 разных роботов (чертежи)

class warrioruran(){
    function build_some_robot0() {
        robot = new robot()
        laser_gun = new LaserGun()
        NuclearReactor = new NuclearReactor()
        walk = new walk()
        
        robot.install_hand(laser_gun)
        robot.install_energy_generator(nuclear_reactor)
        robot.install_walk(walk)
            
        return robot
    }
}

warrioruran = new warrioruran()
Odin = robotwarrioruran.build_some_robot0()
robot.Odin.attack                            // позитивная проверка по основной функции робота
robot.Odin.nuclear_reactor.add              // позитивная проверка по правильной дозаправке робота

robot.Odin.cook                              // негативная проверка по основной функции робота
robot.Odin.battery.add                      // негативная проверка по дозаправке робота (не тот вид топлива)

class warriorfuel(){
    function build_some_robot1() {
        robot = new robot()
        Slash = new Slash()
        gasstation = new gasstation()
        fly = new fly()
        
        robot.install_hand(Slash)
        robot.install_energy_generator(gasstation)
        robot.install_walk(fly)
            
        return robot
    }
}

warriorfuel = new warriorfuel()
Tor = robotwarriorfuel.build_some_robot1()
robot.Tor.attack
robot.Tor.gasstation.add

class warriorbattery(){
    function build_some_robot2() {
        robot = new robot()
        Slash = new Slash()
        battery = new battery()
        drive = new drive()
        
        robot.install_hand(Slash)
        robot.install_energy_generator(battery)
        robot.install_walk(drive)
            
        return robot
    }
}

warriorbattery = new warriorbattery()
Loki = robotwarriorbattery.build_some_robot2()
robot.Loki.attack
robot.Loki.battery.add

class scvuran(){
    function build_some_robot3() {
        robot = new robot()
        scv = new scv()
        NuclearReactor = new NuclearReactor()
        walk = new walk()
        
        robot.install_hand(scv)
        robot.install_energy_generator(NuclearReactor)
        robot.install_walk(walk)
            
        return robot
    }
}

scvuran = new scvuran()
workwork = robotscvuran.build_some_robot3()
robot.workwork.welding
robot.workwork.nuclear_reactor.add

class scvfuel(){
    function build_some_robot4() {
        robot = new robot()
        scv = new scv()
        gasstation = new gasstation()
        walk = new walk()
        
        robot.install_hand(scv)
        robot.install_energy_generator(gasstation)
        robot.install_walk(walk)
            
        return robot
    }
}

scvfuel = new scvfuel()
yesmaster = robotscvfuel.build_some_robot4()
robot.yesmaster.welding
robot.yesmaster.gasstation.add

class scvbattery(){
    function build_some_robot5() {
        robot = new robot()
        scv = new scv()
        battery = new battery()
        walk = new walk()
        
        robot.install_hand(scv)
        robot.install_energy_generator(battery)
        robot.install_walk(walk)
            
        return robot
    }
}

scvbattery = new scvbattery()
withpleasure = robotscvbattery.build_some_robot5()
robot.withpleasure.welding
robot.withpleasure.battery.add

class chefuran(){
    function build_some_robot6() {
        robot = new robot()
        chef = new chef()
        NuclearReactor = new NuclearReactor()
        walk = new walk()
        
        robot.install_hand(chef)
        robot.install_energy_generator(NuclearReactor)
        robot.install_walk(walk)
            
        return robot
    }
}

chefuran = new chefuran()
dionis = robotchefuran.build_some_robot6()
robot.dionis.cook
robot.dionis.nuclear_reactor.add

class cheffuel(){
    function build_some_robot7() {
        robot = new robot()
        chef = new chef()
        gasstation = new gasstation()
        walk = new walk()
        
        robot.install_hand(chef)
        robot.install_energy_generator(gasstation)
        robot.install_walk(walk)
            
        return robot
    }
}

cheffuel = new cheffuel()
dimetra = robotcheffuel.build_some_robot7()
robot.dimetra.cook
robot.dimetra.gasstation.add

class chefbattery(){
    function build_some_robot8() {
        robot = new robot()
        chef = new chef()
        battery = new battery()
        walk = new walk()
        
        robot.install_hand(chef)
        robot.install_energy_generator(battery)
        robot.install_walk(walk)
            
        return robot
    }
}

chefbattery = new chefbattery()
gestia = robotchefbattery.build_some_robot8()
robot.gestia.cook
robot.gestia.battery.add