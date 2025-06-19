# 2D Floor Planner – Java Swing

A desktop-based 2D floor planning tool developed using Java Swing. The application allows users to design simple room layouts by adding and positioning rooms, furniture, doors, and windows with precision and constraints. Layouts can be saved and reloaded with full component state, including images and positions.

---

## Features

- Add and move rooms, furniture, doors, and windows on a canvas
- Grid-snapping for alignment and precision
- Collision detection to prevent overlap
- Edge snapping for accurate door and window placement
- Save and load floor plans using serialized layouts (`layout.ser`)
- Custom icon support via an internal resource folder

---

## How to Run

**Compile:**
```bash
javac *.java
```
## Key Classes
Canvas.java: Main frame and canvas logic; initializes and controls layout

Addroom, Addfurniture, AddDoorWindow: Interfaces to add layout elements

## Author

Kabir Grewal  
[github.com/kabirgrewal1313](https://github.com/kabirgrewal1313)

## License

This project is intended for academic and personal use. All rights reserved.
