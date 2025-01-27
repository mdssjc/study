import shiffman.box2d.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.joints.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;

Box2DProcessing box2d;
Box box;
Spring spring;
ArrayList<Boundary> boundaries;
float xoff;
float yoff;

void setup() {
  size(400, 300);
  box2d = new Box2DProcessing(this);
  box2d.createWorld();

  box = new Box(width/2, height/2);
  spring = new Spring();
  boundaries = new ArrayList<Boundary>();
  boundaries.add(new Boundary(width/2, height-5, width, 10, 0));
  boundaries.add(new Boundary(width/2, 5, width, 10, 0));
  boundaries.add(new Boundary(width-5, height/2, 10, height, 0));
  boundaries.add(new Boundary(5, height/2, 10, height, 0));

  Vec2 pos = box2d.getBodyPixelCoord(box.body);
  spring.bind(pos.x, pos.y, box);

  xoff = 0.0;
  yoff = 0.2;
}

void draw() {
  background(255);

  box2d.step();
  float x = map(noise(xoff), 0, 1, width*0.1, width*0.9);
  float y = map(noise(yoff), 0, 1, width*0.1, height*0.9);
  spring.update(x, y);
  box.display();
  spring.display();
  for (Boundary wall : boundaries) {
    wall.display();
  }

  xoff += .01;
  yoff += .01;
}