package personal.springframework.petclinic.bootstrap;

import java.util.Arrays;
import personal.springframework.petclinic.model.Owner;
import personal.springframework.petclinic.model.Vet;
import personal.springframework.petclinic.services.OwnerService;
import personal.springframework.petclinic.services.VetService;
import personal.springframework.petclinic.services.map.OwnerServiceMap;
import personal.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;

  public DataLoader() {
    ownerService = new OwnerServiceMap();
    vetService = new VetServiceMap();
  }

  @Override
  public void run(String... args) throws Exception {

    Owner owner1 = new Owner();
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Fiona");
    owner2.setLastName("Glenanne");

    ownerService.save(owner2);

    Owner owner3 = new Owner();
    owner3.setFirstName("Nina");
    owner3.setLastName("Simone");

    ownerService.save(owner3);

    System.out.println("Loaded Owners....");
   ownerService.findAll().stream().forEach(owner -> System.out.println("firstName: " + owner.getFirstName()));


    Vet vet1 = new Vet();
    vet1.setId(1L);
    vet1.setFirstName("Sam");
    vet1.setLastName("Axe");

    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setId(2L);
    vet2.setFirstName("Jessie");
    vet2.setLastName("Porter");

    vetService.save(vet2);

    System.out.println("Loaded Vets....");
    vetService.findAll().stream().forEach(owner -> System.out.println("firstName: " + owner.getFirstName()));
  }
}