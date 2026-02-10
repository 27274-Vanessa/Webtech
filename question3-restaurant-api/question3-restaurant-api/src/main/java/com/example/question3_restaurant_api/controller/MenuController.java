package com.example.question3_restaurant_api.controller;

import com.example.question3_restaurant_api.model.MenuItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private List<MenuItem> menuItems = new ArrayList<>();

    public MenuController() {
        menuItems.add(new MenuItem(1L, "Spring Rolls", "Crispy rolls", 5.0, "Appetizer", true));
        menuItems.add(new MenuItem(2L, "Burger", "Beef burger", 10.0, "Main Course", true));
        menuItems.add(new MenuItem(3L, "Pizza", "Cheese pizza", 12.0, "Main Course", false));
        menuItems.add(new MenuItem(4L, "Ice Cream", "Vanilla ice cream", 4.0, "Dessert", true));
        menuItems.add(new MenuItem(5L, "Cake", "Chocolate cake", 6.0, "Dessert", true));
        menuItems.add(new MenuItem(6L, "Coffee", "Hot coffee", 3.0, "Beverage", true));
        menuItems.add(new MenuItem(7L, "Tea", "Green tea", 2.5, "Beverage", true));
        menuItems.add(new MenuItem(8L, "Salad", "Fresh salad", 7.0, "Appetizer", false));
    }

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItems;
    }

    @GetMapping("/{id}")
    public MenuItem getMenuItemById(@PathVariable Long id) {
        return menuItems.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/category/{category}")
    public List<MenuItem> getByCategory(@PathVariable String category) {
        return menuItems.stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @GetMapping("/available")
    public List<MenuItem> getAvailableItems(@RequestParam boolean available) {
        return menuItems.stream()
                .filter(item -> item.isAvailable() == available)
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<MenuItem> searchByName(@RequestParam String name) {
        return menuItems.stream()
                .filter(item -> item.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
        menuItems.add(menuItem);
        return menuItem;
    }

    @PutMapping("/{id}/availability")
    public MenuItem toggleAvailability(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                item.setAvailable(!item.isAvailable());
                return item;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteMenuItem(@PathVariable Long id) {
        menuItems.removeIf(item -> item.getId().equals(id));
        return "Menu item deleted";
    }
}
