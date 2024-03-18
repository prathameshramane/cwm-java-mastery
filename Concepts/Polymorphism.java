package MyJava.Concepts;
abstract class UIControl { 
    private boolean isEnabled = true;

    public abstract void render();
}

class TextBox extends UIControl {
    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("Rendered TextBox !!");
    }

}

class CheckBox extends UIControl {
    private boolean isChecked = false;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public void render() {
        System.out.println("Rendered Checkbox !!");
    }

}

public class Polymorphism {
    public static void main(String[] args) {
        UIControl[] controls = { new TextBox(), new CheckBox() };
        for (UIControl control : controls)
            control.render();
    }
}
