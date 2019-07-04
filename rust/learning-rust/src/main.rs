struct Color {
    red: u8,
    green: u8,
    blue: u8,
}

struct Kilometers(i32);

struct Player {
    first_name: String,
    last_name: String,
}

trait FullName {
    fn full_name(&self) -> String;
}

impl Player {
    fn full_name(&self) -> String {
        format!("{} {}", self.first_name, self.last_name)
    }
}

impl FullName for Player {
    fn full_name(&self) -> String {
        format!("{} {}", self.first_name, self.last_name)
    }
}

fn main() {
    println!("Hello, world!");

    let x = 2;
    let square = |x: i32| -> i32 {
        x * x
    };
    println!("{}", square(x));

    let black = Color { red: 0, green: 0, blue: 0 };
    println!("Black = rgb({}, {}, {})", black.red, black.green, black.blue);

    let distance = Kilometers(20);
    let Kilometers(distance_in_km) = distance;
    println!("The distance: {} km", distance_in_km);

    let player_1 = Player {
        first_name: "Rafael".to_string(),
        last_name: "Nadal".to_string(),
    };
    let player_2 = Player {
        first_name: "Roger".to_string(),
        last_name: "Federer".to_string(),
    };
    println!("Player 01: {}", player_1.full_name());
    println!("Player 02: {}", player_2.full_name());
}
