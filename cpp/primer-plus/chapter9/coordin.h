#ifndef COORDIN_H_
#define  coordin_H_

struct polar
{
    double distance; // distance from origin
    double angle;   // direction from origin 
};

struct rect 
{
    double x;   // horizontal distance from origin 
    double y;   // vertical distance fro origin 
};

// prototypes
polar rect_to_polar(rect xypos);
void show_polar(polar dapos);

#endif


