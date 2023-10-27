package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @OneToOne
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "series")
    private int Series;

    @Column(name = "model")
    private String model;

    public Car() {
    }

    public Car(int series, String model){
        this.Series = series;
        this.model = model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getSeries() {
        return Series;
    }

    public void setSeries(int series) {
        Series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Series=" + Series +
                ", model='" + model + '\'' +
                '}';
    }
}
