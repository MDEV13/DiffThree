# Text of the task

Determine three unique values in sequence, consisting of range integer type of data (32-bit), among values which appear twice.

# Solve

Before we start to solve this task, we should understand how work [the logical operation of XOR (Exclusive or)](https://en.wikipedia.org/wiki/Exclusive_or). For common comprehansive, that is how look *the truth table* this one:

|  x  |  y  | x^y |
|:---:|:---:|:---:|
|  0  |  0  |  0  |
|  0  |  1  |  1  |
|  1  |  0  |  1  |
|  1  |  1  |  0  |

So, it is necessary to convert all values in the array in binary representation and look at **i-th bit** each value for next actions. For instance, take any of sequences and convert it in binary:

Decimal - ***| 7 | 3 | 5 | 8 | 3 | 8 | 9 | <sub>10</sub>***
Binary - ***| 111 | 011 | 101 | 1000 | 011 | 1000 | 1001 | <sub>2</sub>***

From very biggining, find XOR all values in array and identify it as the variable of ***x*** - 11<sub>10</sub> ( 1001<sub>2</sub>).

> Tip!!! 
> It is possible to see that finding the sum of XOR all values, values repeating twice are destroyed. If find XOR only two similar values, we get value equal to 0.
> -- If it does't understand yet, investigate table in the begining and find XOR of two similar values -- 
> In conclusion, we have  the sum of XOR all values equal to XOR all unique values.

Getting to ***x*** actually we find all unique number TOGETHER and our task divide it into 3 single value.

Consider a couple of cases:

<u>**Case 1**</u> - in i-th bit put 0, find the XOR sum all values has in this position - 0 ( it is the variable of ***y*** ). We have two undercase:
    ( 1 ) All values in i-th bit has 0.
    ( 2 ) **The one of these values** in i-th bit has 0, others - 1.
    
<u>**Case 2**</u> - in i-th bit put 1, find the XOR sum all values has in this position - 1 ( it is the variable of ***y*** ). We have two undercase:
    ( 1 ) **The one of these values** in i-th bit has 1, others - 0.
    ( 2 ) All values in i-th bit has 1.
    
In the undercase of finding **the one of unique value**, this value  will be ***y***. The undercase we get the XOR 2 unique values is impossible.

1 0 0 - (1)
0 1 1 - (2)
    or
7 8 2 - (1)
2 7 1 - (2)

At the top we see values which means i-th bit of three unique values,so how exactly we can prove that the undercase related to XOR 2 values obviuosly is impractical?
Here is how, noticed in the table above, let's work out XOR 
these bit.
1.     In (1) we can notice that 1^0^0 = 1.
1.     In (2) we can notice that 0^1^1 = 0.
From example we can do conclusion that first of all we must get one out of three values, it is **y**.
After **y** is found we need to do XOR between **y** and **x** in order to throw away found value. Suppose, we have such three unique values - **7 8 2**. Then first value we will find is **7** whereas **x** stores XOR all values it means to remain only two out of three it is required to find XOR one more time - **8 2**. 
    Remain uncomplicated part, **find two unique values**. Actions are the same, but we must remember about found one, excluding from **y**.
    
Right now to be discussed finding one and remaining values, but also it is possible to appear next cases:

1 1 1 - (1)
0 0 0 - (2)
or
7 1 3 - (1)
4 2 8 - (2)
    
For remaining undercase we need some kind of condition that said us about what unique one is impossible to find. For sovling this problem we can change i-th bit and do so before we have possibility to choose ONE of them.
Let's disassemble case (1) having worked out **x** = 101<sub>2</sub>=5<sub>2</sub>. In this case we get **y** eqaul to **x** whereas if we take for the start (i-th) bit - last index. If you're not understanding now, consider a couple of examples everything's going to be clear.
In the case (2), the variable of **x** = 1110<sub>2</sub>=14<sub>10</sub>. Here we get the same situation.

# Examples 

### *Ex1. Take example in the beginning*

### | **7** | 3 | **5** | 8 | 3 | 8 | **9** | <sub>10</sub>

**Action 1** - Find **x**
<hr>

x = 101<u>1</u><sub>2</sub>=11

<hr>

**Action 2** - Look at i-th bit the variables of **x** and find **y**

<hr>

Suggest to take for the start point of last index in array (i-th bit) - ***n***.
Then we're necessary to take all values with  bit (**0** or **1**) in currently place. Whereas in this place it is **1**, *it needs to find XOR all values whose bit has this binary digit*.
### | **7** | **3** | **5** | 8 | **3** | 8 | **9** | <sub>10</sub>
### | **11<u>1</u>** | **01<u>1</u>** | **10<u>1</u>** | 1000 | **01<u>1</u>** | 1000 | **100<u>1</u>** | <sub>2</sub>
Here, **y** = 1011<sub>2</sub> = 11.
<hr>

**Action 3** - Compare variables **x** and **y**

<hr>

Whereas condition of equality between these variables is adhered. This demonstrate that we don't find right value, so we change place of a bit - *n-1*.
<hr>

**Action 2 (+1)** - Look at i-th bit the variables of **x** and find **y**

<hr>

### | **7** | **3** | 5 | 8 | **3** | 8 | **9** | <sub>10</sub>
### | **1<u>1</u>1** | **0<u>1</u>1** | 101 | 1000 | **0<u>1</u>1** | 1000 | 1001 | <sub>2</sub>
We make some change: x = 10<u>1</u>1<sub>2</sub>=11.
###### **y** = 111<sub>2</sub>=7. - first unique value
This one is first part of our total answer. Whereas we fin d value, it means we have to complete XOR between **x** and **y**. After **x** does not contain **7**, coz it throw away **x** = 1100<sub>2</sub> = 12.
<hr>

**Action 2 (+2)** - Look at i-th bit the variables of **x** and find **y**

<hr>

We make some change: x = 11<u>0</u>0<sub>2</sub>=12.
### | ~~7~~ | 3 | **5** | **8** | 3 | **8** | **9** | <sub>10</sub>
### | ~~111~~ | 011 | **1<u>0</u>1** | **10<u>0</u>0** | 011 | **10<u>0</u>0** | **10<u>0</u>1** | <sub>2</sub>

**y** = 12.
<u>Also is very important to take account to found value doesn't take part in calculation process</u>
Variables are equal, come to next place of a bit - *n-2*.
<hr>

**Action 2 (+3)** - Look at i-th bit the variables of **x** and find **y**

<hr>

We make some change: x = 1<u>1</u>00<sub>2</sub>=12.
### | **~~7~~** | 3 | **~~5~~** | 8 | 3 | 8 | ~~9~~ | <sub>10</sub>
### | **~~<u>1</u>11~~** | 011 | **~~<u>1</u>01~~** | 1000 | 011 | 1000 | ~~1001~~ | <sub>2</sub>

###### **y** = 5, because of throwing away **7** from calculation.
Whereas next to end we're needed to find **two remaining values**, that's mean executing XOR
###### **x** = 1100\^101 = 1001<sub>2</sub>=9.
This is our final and TOTAL value. Well done :)
<hr>

### *Ex2. Take another*

### | **4** | 8 | 8 | **9** | 3 | 3 | **34** | <sub>10</sub>

**Action 1** - Find **x**
<hr>

x = 10111<u>1</u><sub>2</sub>=47.

<hr>

**Action 2..n** 

<hr>

### | **4** | 8 | 8 | **9** | 3 | 3 | **34** | <sub>10</sub>
### | 100 | 1000 | 1000 | **1001** | **011** | **011** | 100010 | <sub>2</sub>

###### **y**= 1001<sub>2</sub>=9.
**x** = 10011<u>0</u>= 37.

### | **~~4~~** | **8** | **8** | ~~9~~ | 3 | 3 | **~~34~~** | <sub>10</sub>
### | **10<u>0</u>** | **100<u>0</u>** | **100<u>0</u>** | 1001 | 011 | 011 | **10001<u>0</u>** | <sub>2</sub>

###### **y**= 100010<sub>2</sub>=34.
###### **x** = 100<sub>2</sub>= 4.

<hr>