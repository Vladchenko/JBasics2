package ru.coursera.designpatterns.adapter;

/**
 * Coffee machine adapter.
 *
 * @author Yanchenko Vladislav
 * @since 22.02.2021
 */
public class CoffeeTouchScreenAdapter implements CoffeeMachineInterface {

    private OldCoffeeMachine mOldCoffeeMachine;

    public CoffeeTouchScreenAdapter(OldCoffeeMachine oldCoffeeMachine) {
        mOldCoffeeMachine = oldCoffeeMachine;
    }

    @Override
    public void chooseFirstSelection() {
        mOldCoffeeMachine.selectA();
    }

    @Override
    public void chooseSecondSelection() {
        mOldCoffeeMachine.selectB();
    }
}
