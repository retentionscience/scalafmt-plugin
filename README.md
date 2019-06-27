# scalafmt-plugin

## A plugin that fetches the latest `.scalafmt.conf` file and imports it into the current project.

### Notes
1. Only works with SBT 1.2.8 (Scala 2.12)
    1. Was able to cross-compile with SBT 0.13.x (Scala 2.10), but the plugin did not execute.

### How to use this plugin
1. Update the project's SBT version to 1.2.8
2. Update dependencies from the SBT migration
3. Add the latest `scalafmt-plugin` version to `plugins.sbt`
    ```
    addSbtPlugin("com.retentionscience" % "scalafmt-plugin" % "0.0.1")
    ```
4. Enable the plugin inside `build.sbt`
    ```
    enablePlugins(ScalafmtRemoteConfigPlugin)
    ```
5. The latest `.scalafmt.conf` file will be downloaded to the project's root directory on each compile
6. Verify IntelliJ is using `scalafmt` as the default Scala Code Formatter in *Preferences > Editor > Code Style > Scala*
    1. Optionally check the box for `Reformat on file save`