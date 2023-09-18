package code.test;

/**
 宠物店买宠物
 */
public class PetTest2 {

    public static void main(String[] args) {

        System.out.println("张三来到宠物店买宠物");

        Pet pet = buyPet("cat");
        //如果有值可能为空   需要提前判断
        if (pet == null){
            return;
        }
        pet.showInfo();  //NullPointerException  点错误提示第一个链接   在这句代码中找.前面的对象，就是它空了

        if (pet instanceof Cat){
            ((Cat)pet).catchMouse();
        }else if(pet instanceof Dog){
            Dog d = (Dog)pet;
            d.shout();
            d.watchDoor();
        }
    }

    public static Pet buyPet(String what){

        if("cat".equals(what)){

            Cat cat = new Cat();
            cat.nickName = "大花";
            cat.age = 2;
            cat.brand = "橘猫";

            return cat;
        }else if("dog".equals(what)){

            Dog dog = new Dog();
            dog.nickName = "富贵";
            dog.age = 3;
            dog.brand = "土狗";

            return dog;
        }else{

            System.out.println("暂时没有这种宠物");
            return null;
        }

    }

}
