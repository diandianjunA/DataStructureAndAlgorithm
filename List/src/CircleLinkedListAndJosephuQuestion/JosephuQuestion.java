package CircleLinkedListAndJosephuQuestion;

import org.testng.annotations.Test;

public class JosephuQuestion {
    @Test
    public void CircleLinkedListTest(){
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.add(5);
        circleLinkedList.list();
    }
    @Test
    public void JosephuQuestion(){
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.counting(10,20,125);
    }
}
