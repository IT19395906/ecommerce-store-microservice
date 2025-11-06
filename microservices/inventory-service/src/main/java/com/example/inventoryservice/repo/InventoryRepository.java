package com.example.inventoryservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.inventoryservice.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    @Query(value = "SELECT * FROM inventory WHERE item_id = ?1", nativeQuery = true)
    Inventory getItemByItemId(Integer itemId);
}
