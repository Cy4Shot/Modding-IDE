package io.github.railroad.menu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;

import static io.github.railroad.lang.LangManager.ENGLISH;
import static io.github.railroad.lang.LangManager.getLocalization;
import static io.github.railroad.utility.Components.MenuItemFactory.makeMenuItem;
import static io.github.railroad.utility.Components.createImage;
import static io.github.railroad.utility.FileChoosers.createNewGenericFile;
import static io.github.railroad.utility.FileChoosers.createNewJavaFile;
import static io.github.railroad.utility.Templates.JavaTemplate.*;

/**
 * Creates all of the items of the top menu.
 *
 * @author TheOnlyTails
 */
public final class TopMenu extends MenuBar {

    private final String javaProjectIconPath = "java_project";

    /**
     * Creates the top menu and adds all of the submenus.
     *
     * @author TheOnlyTails
     */
    public void createMenu() {
        final var fileMenu = new Menu(getLocalization("menu.file", ENGLISH));
        createFileMenu(fileMenu);

        final var editMenu = new Menu(getLocalization("menu.edit", ENGLISH));
        createEditMenu(editMenu);

        final var searchMenu = new Menu(getLocalization("menu.search", ENGLISH));
        createSearchMenu(searchMenu);

        // TODO: these menus are all empty.
        final var runMenu = new Menu(getLocalization("menu.run", ENGLISH));
        final var viewMenu = new Menu(getLocalization("menu.view", ENGLISH));
        final var helpMenu = new Menu(getLocalization("menu.help", ENGLISH));

        getMenus().addAll(fileMenu, editMenu, searchMenu, runMenu, viewMenu, helpMenu);
    }

    /**
     * Creates the file submenu and all of its submenus.
     *
     * @param fileMenu the object that contains the file submenu.
     * @author TheOnlyTails
     */
    public void createFileMenu(Menu fileMenu) {
        createFileNewMenu(fileMenu);
        createFileGenerateMenu(fileMenu);
        fileMenu.getItems().add(new SeparatorMenuItem());

        final var open = makeMenuItem(getLocalization("menu.file.open", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var recent = makeMenuItem(getLocalization("menu.file.open_recent", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var save = makeMenuItem(getLocalization("menu.file.save", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var saveAs = makeMenuItem(getLocalization("menu.file.save_as", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var export = makeMenuItem(getLocalization("menu.file.export", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        fileMenu.getItems().addAll(open, recent, new SeparatorMenuItem(), save, saveAs, export);
    }

    /**
     * Creates the new file submenu and all of its submenus.
     *
     * @param fileMenu the object that contains the new file submenu.
     * @author TheOnlyTails
     */
    public void createFileNewMenu(Menu fileMenu) {
        final var newMenu = new Menu(getLocalization("menu.file.new", ENGLISH));
        final var javaProject = makeMenuItem(getLocalization("menu.file.new.java_project", ENGLISH))
                .graphic(createImage(javaProjectIconPath))
                .get();

        final var project = makeMenuItem(getLocalization("menu.file.new.project", ENGLISH))
                .graphic(createImage("project"))
                .get();

        final var workingSet = makeMenuItem(getLocalization("menu.file.new.java_working_set", ENGLISH))
                .graphic(createImage("working_set"))
                .get();

        final var packageItem = makeMenuItem(getLocalization("menu.file.new.package", ENGLISH))
                .graphic(createImage("package"))
                .get();

        final var source = makeMenuItem(getLocalization("menu.file.new.source_folder", ENGLISH))
                .graphic(createImage("source_folder"))
                .get();

        final var file = makeMenuItem(getLocalization("menu.file.new.file", ENGLISH))
                .graphic(createImage("file"))
                .action(event -> createNewGenericFile())
                .get();

        final var folderItem = makeMenuItem(getLocalization("menu.file.new.folder", ENGLISH))
                .graphic(createImage("folder"))
                .get();

        final var classItem = makeMenuItem(getLocalization("menu.file.new.class", ENGLISH))
                .graphic(createImage("class"))
                .action(event -> createNewJavaFile(CLASS, CLASS_NAME))
                .get();

        final var interfaceItem = makeMenuItem(getLocalization("menu.file.new.interface", ENGLISH))
                .graphic(createImage("interface"))
                .action(event -> createNewJavaFile(INTERFACE, INTERFACE_NAME))
                .get();

        final var enumItem = makeMenuItem(getLocalization("menu.file.new.enum", ENGLISH))
                .graphic(createImage("enum"))
                .action(event -> createNewJavaFile(ENUM, ENUM_NAME))
                .get();

        final var annotationItem = makeMenuItem(getLocalization("menu.file.new.annotation", ENGLISH))
                .graphic(createImage("annotation"))
                .action(event -> createNewJavaFile(ANNOTATION, ANNOTATION_NAME))
                .get();

        newMenu.getItems().addAll(javaProject, project, workingSet, new SeparatorMenuItem(),
                source, packageItem, file, folderItem, new SeparatorMenuItem(),
                classItem, interfaceItem, enumItem, annotationItem);

        fileMenu.getItems().add(newMenu);
    }

    /**
     * Creates the generate file submenu and all of its submenus.
     *
     * @param fileMenu the object that contains the generate file submenu.
     * @author TheOnlyTails
     */
    public void createFileGenerateMenu(Menu fileMenu) {
        final var generateMenu = new Menu(getLocalization("menu.file.generate", ENGLISH));
        final var forgeMod = makeMenuItem(getLocalization("menu.file.generate.forge_mod", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var fabricMod = makeMenuItem(getLocalization("menu.file.generate.fabric_mod", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var itemModel = makeMenuItem(getLocalization("menu.file.generate.item_model", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var blockModel = makeMenuItem(getLocalization("menu.file.generate.block_model", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var blockState = makeMenuItem(getLocalization("menu.file.generate.block_state", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        generateMenu.getItems().addAll(forgeMod, fabricMod, new SeparatorMenuItem(), itemModel, blockModel, blockState);
        fileMenu.getItems().add(generateMenu);
    }

    /**
     * Creates the edit submenu and all of its submenus.
     *
     * @param editMenu the object that contains the edit submenu.
     * @author TheOnlyTails
     */
    public void createEditMenu(Menu editMenu) {
        final var undo = makeMenuItem(getLocalization("menu.edit.undo", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var redo = makeMenuItem(getLocalization("menu.edit.redo", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var cut = makeMenuItem(getLocalization("menu.edit.cut", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var copy = makeMenuItem(getLocalization("menu.edit.copy", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var paste = makeMenuItem(getLocalization("menu.edit.paste", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var delete = makeMenuItem(getLocalization("menu.edit.delete", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var selectAll = makeMenuItem(getLocalization("menu.edit.select_all", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var findReplace = makeMenuItem(getLocalization("menu.edit.find_replace", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        editMenu.getItems().addAll(undo, redo, new SeparatorMenuItem(), cut, copy, paste, new SeparatorMenuItem(), delete,
                selectAll, new SeparatorMenuItem(), findReplace);
    }

    /**
     * Creates the search submenu and all of its submenus.
     *
     * @param searchMenu the object that contains the search submenu.
     * @author TheOnlyTails
     */
    public void createSearchMenu(Menu searchMenu) {
        final var search = makeMenuItem(getLocalization("menu.search.search", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var textMenu = new Menu(getLocalization("menu.search.text", ENGLISH));

        final var workspace = makeMenuItem(getLocalization("menu.search.text.workspace", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var project = makeMenuItem(getLocalization("menu.search.text.project", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        final var file = makeMenuItem(getLocalization("menu.search.text.file", ENGLISH))
                .graphic(createImage(javaProjectIconPath)).get();

        searchMenu.getItems().addAll(search, new SeparatorMenuItem(), textMenu);
        textMenu.getItems().addAll(workspace, project, file);
    }
}
