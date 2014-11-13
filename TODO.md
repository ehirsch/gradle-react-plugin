# TODO

Only some notes about what i think might be useful.
(for me to learn and/or the project to become better)

- **More configurations** -
  It should be possible to provide all the options which are understood by the jsx transpiler

- **Example with harmony** -
  Simply to show of some of the config options in action

- **Explain usage for gradle before and since 2.1** -
  This should become a new paragraph in README.md

- **A more gradle-ish version** -
  right now the version is simply hardcoded - we can do better than that ;)

- **Clean up** -
  I don't remove any build artifacts - no good.

- **Create a convention** -
  There is this concept of convetions in gradle - will have to look into that…

## doing

- **Release/deploy** -
  I never released anything to bintray or plugins.gradle.org. Curious how this might work.

- **Configure inputs and output.** -
  Right now the sources and their transformations have to be located at exactly one directory. This has to change.


## done

- ~~**Compile -> transform** -
  I wrote some comments about jsx compiling things - that not quite correct. Change this into *transfrom*~~


## Related

- **Create a fix for a gradle-grund-plugin bug** -
  I found this while writing this plugin here. The bug will prevent the plugin from installing anything if the output
  folder was not created before use.
