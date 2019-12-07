package hoeckbankgroup.demo.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persoon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personID;


}
