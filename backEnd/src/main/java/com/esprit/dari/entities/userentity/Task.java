package com.esprit.dari.entities.userentity;

import com.esprit.dari.entities.CallEtats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
    public class Task implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String taskName;
        private CallEtats callRequest=CallEtats.encour;
        private LocalDateTime dateTask;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserDari userDaris ;
}
