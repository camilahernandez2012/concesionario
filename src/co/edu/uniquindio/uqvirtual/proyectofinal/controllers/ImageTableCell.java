package co.edu.uniquindio.uqvirtual.proyectofinal.controllers;

import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public  class ImageTableCell<S, T> extends TableCell<S, T> {
    private ImageView imageView;

    public ImageTableCell() {
        imageView = new ImageView();
        imageView.setFitHeight(25); // Altura de la imagen
        imageView.setFitWidth(25); // Ancho de la imagen
        setGraphic(imageView);
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            imageView.setImage(null);
        } else {
            String imagePath = item.toString();
            Image image = new Image(imagePath);
            imageView.setImage(image);
        }
    }
}