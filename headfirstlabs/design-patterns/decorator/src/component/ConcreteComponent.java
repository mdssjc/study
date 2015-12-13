package component;

public class ConcreteComponent extends Component {

    @Override
    public String text() {
        return String.valueOf(getResult());
    }
}