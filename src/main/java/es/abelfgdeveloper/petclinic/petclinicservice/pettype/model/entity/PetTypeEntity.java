package es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "pet_types")
public class PetTypeEntity {

  @Id @EqualsAndHashCode.Include private String id;

  @Column(name = "name")
  private String name;

  @PrePersist
  void prePersist() {
    this.id = UUID.randomUUID().toString();
  }
}
