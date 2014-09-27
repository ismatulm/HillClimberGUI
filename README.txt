HillClimberGUI
==============

A simple hill climbing Java GUI application. 
Problem: 
Miminize f(v) = f(x1, x2, x3) = x1^2 + x2^2 + x3^2 for -10 <= x1, x2, x3 <= +15.
That is, find the vector v = {x1, x2, x3} such that f(v) is the minimum in the given range.

Input: N, MAX, DESIRED_FUNCTION_VALUE
Output: t, v_c, f(v_c)




Algorithm Iterated Hillclimber

t = 0;
repeat
      local = false;
      select a current vector v_c at random;
      evaluate f(v_c);
      if f(v_c) <= DESIRED_FUNCTION_VALUE
         then goto FINISH; 
      repeat
            select N new vectors (call them v_1 through v_N) in the neighborhood of v_c by small, random perturbation of one or more dimensions;
            evaluate f(v_1), f(v_2), ..., f(v_N);
            select the vector with the smallest value of f(); Call it v_new; 
            if f(v_new) < f(v_c)
               then begin 
                       v_c = v_new;
                       if f(v_c) <= DESIRED_FUNCTION_VALUE
                          then goto FINISH; 
                    end
               else local = true;
      until local;
      t = t + 1;
until t = MAX; 
FINISH: Output t, v_c, f(v_c)

Task 1: Implemented this in Java
Task 2: Implemented this in Java GUI, complete with user interfaces for start, input, output.
