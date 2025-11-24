package com.jsantos.metadata.plugin.ui.view;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.printing.*;

public class Test {

	Display display;

	Shell shell;

	Tree tree;

	Image treeImage;

	Printer printer;

	GC gc;

	int leftMargin, rightMargin, topMargin, bottomMargin;

	int x, y;

	public static void main(String[] args) {

		new Test().open();

	}


	void open() {

		display = new Display();

		shell = new Shell(display);

		shell.setLayout(new FillLayout());

		shell.setText("Print Tree");

		/* Create a sample Tree widget */

		tree = new Tree (shell, SWT.BORDER);

		for (int i=0; i<4; i++) {

			TreeItem iItem = new TreeItem (tree, 0);

			iItem.setText ("TreeItem (0) -" + i);

			for (int j=0; j<4; j++) {

				TreeItem jItem = new TreeItem (iItem, 0);

				jItem.setText ("TreeItem (1) -" + j);

				for (int k=0; k<4; k++) {

					TreeItem kItem = new TreeItem (jItem, 0);

					kItem.setText ("TreeItem (2) -" + k);

					for (int l=0; l<4; l++) {

						TreeItem lItem = new TreeItem (kItem, 0);

						lItem.setText ("TreeItem (3) -" + l);

					}

				}

			}

		}


		Menu menuBar = new Menu(shell, SWT.BAR);

		shell.setMenuBar(menuBar);

		MenuItem item = new MenuItem(menuBar, SWT.CASCADE);

		item.setText("&File");

		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);

		item.setMenu(fileMenu);

		item = new MenuItem(fileMenu, SWT.NULL);

		item.setText("&Print...");

		item.setAccelerator(SWT.CTRL + 'P');

		item.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {

				menuPrint();

			}

		});

		new MenuItem(fileMenu, SWT.SEPARATOR);

		item = new MenuItem(fileMenu, SWT.NULL);

		item.setText("E&xit");

		item.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {

				System.exit(0);

			}

		});


		shell.pack();

		shell.open();

		while (!shell.isDisposed()) {

			if (!display.readAndDispatch()) display.sleep();

		}

		treeImage.dispose();

	}

	void menuPrint() {

		PrintDialog dialog = new PrintDialog(shell, SWT.NULL);

		PrinterData data = dialog.open();

		if (data == null) return;


		/* Snap the Tree widget. */

		Rectangle treeBounds = tree.getBounds();

		if (treeImage != null) treeImage.dispose();

		treeImage = new Image(display, treeBounds.width, treeBounds.height);

		GC gc = new GC(tree);

		gc.copyArea(treeImage, 0, 0);

		gc.dispose();


		/* Copy the image to a printer-compatible image. */

		ImageData imageData = treeImage.getImageData();

		if (treeImage != null) treeImage.dispose();

		treeImage = new Image(printer, imageData);

		/* Do the printing in a background thread so that spooling does not freeze
the UI. */

		printer = new Printer(data);

		Thread printingThread = new Thread("Printing") {

			public void run() {

				print(printer);

				printer.dispose();

			}

		};

		printingThread.start();

	}


	void print(Printer printer) {

		if (printer.startJob("Tree")) {

			Rectangle clientArea = printer.getClientArea();

			Rectangle trim = printer.computeTrim(0, 0, 0, 0);

			Point dpi = printer.getDPI();

			leftMargin = dpi.x + trim.x; // one inch from left side of paper

			rightMargin = clientArea.width - dpi.x + trim.x + trim.width; // one inch

			topMargin = dpi.y + trim.y; // one inch from top edge of paper

			bottomMargin = clientArea.height - dpi.y + trim.y + trim.height; // one inch


			/* Create printer GC and print image to it. */

			gc = new GC(printer);

			printer.startPage();

			Rectangle imageBounds = treeImage.getBounds();

			x = clientArea.width / 2 - dpi.x; // center image horizontally

			y += dpi.y; // draw 2" wide image 1" below text

			gc.drawImage(treeImage, 0, 0, imageBounds.width, imageBounds.height,

					x, y, dpi.x * 2, dpi.y * 2 * imageBounds.height / imageBounds.width);

			printer.endPage();

			printer.endJob();

			/* Cleanup graphics resources used in printing */

			gc.dispose();

		}

	}

}
