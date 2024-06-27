package GDSalles.example.GDSalles.service;

import GDSalles.example.GDSalles.entity.Equipment;
import GDSalles.example.GDSalles.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> getAllEquipments() {
        return equipmentRepository.findAll();
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElse(null);
    }

    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipment(Equipment equipment) {
        return equipmentRepository.findById(equipment.getId())
                .map(equipmentToUpdate -> {
                    equipmentToUpdate.setName(equipment.getName());
                    equipmentToUpdate.setQuantity(equipment.getQuantity());
                    equipmentToUpdate.setType(equipment.getType());
                    return equipmentRepository.save(equipmentToUpdate);
                })
                .orElseGet(() -> equipmentRepository.save(equipment));
    }

    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }
}
