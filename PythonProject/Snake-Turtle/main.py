"""
NEU SF Align 2020
Final Exam Question 3 - Turtle
Name: Shaohua(Teresa) Liu
"""
import turtle
import math
import time
velocity = 1


class TurtleGame:

    def __init__(self):
        self.screen = turtle.Screen()
        self.turt_avadar = turtle.Turtle()
        self.turt_arena = turtle.Turtle()
        self.turt_info = turtle.Turtle()

    def __str__(self):
        return str("playing the turtle game")

    def setup_screen(self):
        self.screen.bgcolor("lightpink")
        return self.screen

    def write_info(self, info):
        if not isinstance(info, str):
            raise TypeError
        self.turt_info.penup()
        self.turt_info.goto(-100, 200)
        self.turt_info.pendown()
        self.turt_info.write(info, font=("Arial", 16, "normal"))
        self.turt_info.penup()
        self.turt_info.hideturtle()

    def set_circular_arena(self, radius=300):
        if not isinstance(radius, int):
            raise TypeError
        self.turt_arena.penup()
        self.turt_arena.goto(0, -300)
        self.turt_arena.speed("fastest")
        self.turt_arena.color("yellow")
        self.turt_arena.pensize(10)
        self.turt_arena.pendown()
        self.turt_arena.begin_fill()
        self.turt_arena.circle(radius)
        self.turt_arena.end_fill()
        return self.turt_arena

    def setup_turt_avadar(self, color="black", shape="square"):
        if not isinstance(color, str):
            raise TypeError
        if not isinstance(shape, str):
            raise TypeError
        self.turt_avadar.color(color)
        self.turt_avadar.shape(shape)
        self.turt_avadar.penup()
        self.turt_avadar.speed(0)
        return self.turt_avadar

    def turn_left(self, degree=20):
        if not isinstance(degree, int):
            raise TypeError
        self.turt_avadar.left(degree)

    def turn_right(self, degree=20):
        if not isinstance(degree, int):
            raise TypeError
        self.turt_avadar.right(degree)

    def velocity_change(self, click):
        if not isinstance(click, int):
            raise TypeError
        global velocity
        velocity = click
        return velocity


def main():
    import turtle
    start = time.time()
    game = TurtleGame()
    game.setup_screen()
    game.set_circular_arena()
    game.setup_turt_avadar()

    turtle.listen()
    turtle.onkey(game.turn_left, "Left")
    turtle.onkey(game.turn_right, "Right")
    turtle.onkey(game.velocity_change(1), "1")
    # turtle.onkey(game.velocity_change(2), "2")
    # turtle.onkey(game.velocity_change(3), "3")
    # turtle.onkey(game.velocity_change(4), "4")

    life_point = 10
    while life_point > 0:
        game.turt_avadar.forward(velocity)
        (a, b) = game.turt_avadar.pos()
        if math.sqrt(a ** 2 + b ** 2) >= 300:
            game.turt_avadar.left(180)
            life_point -= 1
            game.write_info("You still have " + str(life_point) + " lives")

    time.sleep(1)
    end = time.time()
    run_time = end - start
    points = run_time * velocity
    try:
        with open("turtle_gama_points.txt") as f:
            data = f.read()
            data += "\n" + str(points)
            f.write(data)
    except PermissionError:
        print("Permission is not allowed")
    except OSError:
        print("OSError")


if __name__ == "__main__":
    main();
