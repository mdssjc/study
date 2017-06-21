class Car {

  Box bodywork;
  Particle wheel1;
  Particle wheel2;

  Car(float x, float y) {
    bodywork = new Box(x, y, 100, 30, false);
    wheel1 = new Particle(x-28, y+12, 12, false);
    wheel2 = new Particle(x+28, y+12, 12, false);

    RevoluteJointDef rjd1 = new RevoluteJointDef();
    rjd1.initialize(bodywork.body, wheel1.body, wheel1.body.getWorldCenter());
    rjd1.motorSpeed = -PI*2;
    rjd1.maxMotorTorque = 300.0;
    rjd1.enableMotor = true;
    box2d.world.createJoint(rjd1);

    RevoluteJointDef rjd2 = new RevoluteJointDef();
    rjd2.initialize(bodywork.body, wheel2.body, wheel2.body.getWorldCenter());
    rjd2.motorSpeed = -PI*2;
    rjd2.maxMotorTorque = 300.0;
    rjd2.enableMotor = true;
    box2d.world.createJoint(rjd2);
  }

  void display() {
    bodywork.display();
    wheel1.display();
    wheel2.display();
  }
}