# scalafmt-plugin

## A plugin that fetches the latest `.scalafmt.conf` file and imports it into the current project.

### Notes
1. Any changes to the company-wide Scala style should be made here
2. Works with SBT 0.13.x and 1.x
3. Overwrites the existing file if it already exists

### How to use this plugin
1. Add the latest `scalafmt-plugin` version to `plugins.sbt`
    ```
    addSbtPlugin("com.retentionscience" % "scalafmt-plugin" % "0.0.1")
    ```
2. The latest `.scalafmt.conf` file will be downloaded to the project's root directory on each `sbt update`
3. Verify IntelliJ is using `scalafmt` as the default Scala Code Formatter in *Preferences > Editor > Code Style > Scala*
    1. Optionally check the box for `Reformat on file save`
