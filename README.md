# Spintaxkt

Spintaxkt is a Kotlin library for parsing spintax strings and generating all possible combinations
of sentences.

## What is spintax?

Spintax, short for "spin syntax," is a format for representing alternative versions of a piece of
text within a single string. It is commonly used in content generation, such as in article spinning
software or email marketing templates.

In spintax, alternative versions of a piece of text are enclosed in curly braces `{}` and separated
by a vertical bar `|`. For example, the spintax string `"{Hello|Hi} {world|there}"` has two choices,
each with two alternatives. When expanded, this spintax string generates four possible sentences:

- `"Hello world"`
- `"Hello there"`
- `"Hi world"`
- `"Hi there"`

Spintax can also be nested, allowing for more complex combinations of alternatives.

## Setup

To use Spintaxkt in your project, add the following dependency to your `build.gradle` file:

```kotlin
dependencies {
    implementation("com.jamshedalamqaderi.kotlin:spintaxkt:1.0.0")
}
```

## Usage

To parse a spintax string and generate all possible combinations of sentences, you can use
the `SpintaxkUtils` object as follows:

```kotlin
import com.jamshedalamqaderi.kotlin.spintaxkt.SpintaxkUtils

val spintax = "{Hello|Hi} {world|there}"
val parser = spintax.parser()
val sentences = parser.sentences()
// sentences == listOf("Hello world", "Hello there", "Hi world", "Hi there")
```

You can also use the `variations()` method to get the total number of variations:

```kotlin
val variations = parser.variations()
// variations == 4
```

Or use the sentence() method to get a random sentence:

```kotlin
val sentence = parser.sentence()
// sentence == "Hello world" (or any other combination)
```

# Contributing

We welcome contributions to Spintaxkt! If you have an idea for a new feature or bug fix, please open
an issue or pull request.

## Support

If you found Spintaxkt useful and would like to support its development, you can donate via Patreon
by clicking on the button below:

[![Support via Patreon](https://c5.patreon.com/external/logo/become_a_patron_button.png)](https://patreon.com/JamshedAlamQaderi)

## Credits

Spintaxkt was developed by [JamshedAlamQaderi](https://github.com/JamshedAlamQaderi/JamshedAlamQaderi).

## License

Spintaxkt is licensed under the Apache License 2.0.

Copyright [2023] [jamshedalamqaderi.com]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.