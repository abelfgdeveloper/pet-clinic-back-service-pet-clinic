package es.abelfgdeveloper.petclinic.petclinicservice.pet.model.entity;

import java.time.LocalDate;
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
@Table(name = "pets")
public class PetEntity {

  @Id @EqualsAndHashCode.Include private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  @Column(name = "pet_type_id")
  private String petTypeId;

  @Column(name = "owner_id")
  private String ownerId;

  @PrePersist
  void prePersist() {
    this.id = UUID.randomUUID().toString();
  }
}
