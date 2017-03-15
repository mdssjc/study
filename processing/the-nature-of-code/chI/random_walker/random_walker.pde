class Walker {
  int x;
  int y;

  Walker() {
    x = width/2;
    y = height/2;
  }
  
  void display() {
    stroke(0);
    point(x,y);
  }
  
  void step() {
    int stepx = int(random(3))-1;
    int stepy = int(random(3))-1;
    
    x += stepx;
    y += stepy;
  }
}

Walker w;
int[] randomCounts;

void setup() {
  //size(640,360);
  //w = new Walker();
  //background(255);
  
  size(640,240);
  randomCounts = new int[20];
}

void draw() {
  //w.step();
  //w.display();
  
  background(255);
  
  int index = int(random(randomCounts.length));
  randomCounts[index]++;
  
  stroke(0);
  fill(175);
  int w = width/randomCounts.length;
  for (int x = 0; x < randomCounts.length; x++) {
    rect(x*w, height-randomCounts[x], w-1, randomCounts[x]);
  }
}