package designPattern;

interface Animal {
    public void printDescription();
}


class AnimalFactory {
    public static Animal create(String animalName){
        if (animalName == null) {
            return null;
        }
        if (animalName.equals("소")) {
            return new Cow();
        }else if (animalName.equals("고양이")) {
            return new Cat();
        }else if (animalName.equals("개")) {
            return new Dog();
        }else{
            return null;
        }
    }
}


class Cat implements Animal {
    public void printDescription() {
        System.out.println("쥐잡기 선수");
    }
}


class Cow implements Animal {
    public void printDescription() {
        System.out.println("우유 및 고기 제공");
    }
}


class Dog implements Animal {
    public void printDescription() {
        System.out.println("주로 집 지킴");
    }
}


public class FactoryMethodSample {
    public static void main(String[] args) {
        Animal a1= AnimalFactory.create("소");
        a1.printDescription();
        Animal a2= AnimalFactory.create("고양이");
        a2.printDescription();
        Animal a3= AnimalFactory.create("개");
        a3.printDescription();
    }
}
