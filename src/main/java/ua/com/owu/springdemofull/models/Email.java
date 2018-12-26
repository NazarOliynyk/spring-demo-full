package ua.com.owu.springdemofull.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = {"user"})
@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    @ManyToOne(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    private User user;
}
