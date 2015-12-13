package decorator;

import component.Component;

public class Decorator2 extends Component {
    private Component component;

    public Decorator2(Component component) {
        this.component = component;
    }

    @Override
    public String text() {
        return "==" + component.text() + "==";
    }
}