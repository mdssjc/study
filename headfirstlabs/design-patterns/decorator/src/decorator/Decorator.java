package decorator;

import component.Component;

public class Decorator extends Component {
    private Component component;

    public Decorator(Component component) {
	this.component = component;
    }

    @Override
    public String text() {
	return "[" + component.text() + "]";
    }
}
