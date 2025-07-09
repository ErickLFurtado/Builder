import com.exemplo.CarBuilder;
import com.exemplo.Director;
import com.exemplo.ManualBuilder;
import com.exemplo.cars.Car;
import com.exemplo.cars.CarManual;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        ManualBuilder manualBuilder = new ManualBuilder();
        director.constructCityCar(manualBuilder);
        CarManual carManual = manualBuilder.getResult();
        System.out.println("\nManual Built: \n" + carManual.print());

    }
}