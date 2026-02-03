package com.KarimAhmed.TaskManager.Repository;


/*why should i use .txt or .csv for storing data why not use java objectstream and store
everything as java object?

That is an incredibly insightful question. You're talking about Java Serialization
(using ObjectOutputStream and ObjectInputStream). It allows you to save an entire object
directly to a binary file with one command.

You are 100% correct: the user shouldn't care how the data is stored. However,
there are three very specific reasons why professional developers almost always choose CSV,
JSON, or SQL over Java's built-in "Object DataStreams."

1. The "Version" Nightmare (The #1 Reason)
Imagine you save 50 tasks using your current Task class. Tomorrow,
you decide to add a priority field to the Task class.

With CSV/Pipes: You just update your code to look for one more column. No big deal.

With Object Streams: Java will throw an InvalidClassException. The "Serial Version" of
the class changed, and Java will refuse to read the old file.
You would lose all your data every time you update your code!

2. Portability (Language Barriers)
Java DataStreams are binary. They can only be read by other Java programs.

If you ever wanted to write a mobile app in Flutter or a website in JavaScript that
looks at the same data file, they wouldn't be able to understand the "Java Object" format.

CSV and Text are "Universal." Every language on earth can read them.

3. Debugging and Transparency
As a developer, sometimes things go wrong.

With Pipes: You can open tasks.txt in Notepad and see: 1|Fix Bug|High|PENDING.
You can manually fix a typo or see exactly what's wrong.

With Object Streams: If you open the file, it looks like gibberish symbols and "alien"
characters. You are "blind" to your own data.

Is there a middle ground?
If you want the "ease" of Object Streams but the "safety" of text,
the industry standard is JSON (JavaScript Object Notation). It looks like this:

JSON
{
  "id": 1,
  "name": "Buy Milk",
  "status": "PENDING"
}
It’s a "text object." However, for a learning project, writing your own Pipe-separated parser
is a rite of passage for Java developers. It teaches you how String.split() and
File I/O really work.

My Recommendation for Your Portfolio:
Stick with Pipes (|) or CSV.

It shows you can handle String Manipulation.

It shows you understand Data Persistence basics.

It makes your project "readable" to anyone who downloads your code.
 */
public class TaskRepository {
}
