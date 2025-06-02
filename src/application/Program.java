package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		String option = "";

		while (!option.equalsIgnoreCase("sair")) {
			System.out.println("-----------------------------");
			System.out.println("---- CONTROLE DE ESTOQUE ----");
			System.out.println("-----------------------------");
			System.out.println();
			System.out.println("----------- MENU ------------");
			System.out.println();
			System.out.println("1. Adicionar produto");
			System.out.println("2. Adicionar quantidade ao estoque");
			System.out.println("3. Retirar uma quantidade do estoque");
			System.out.println("4. Remover produto");
			System.out.println("5. Ver lista de produtos");
			System.out.println();
			System.out.println("Digite 'sair' para encerrar o programa");
			System.out.println();
			System.out.println("------------------------------");
			System.out.println();
			System.out.print("Digite uma opção: ");
			option = sc.nextLine().toLowerCase();

			switch (option) {
			case "1":
				System.out.println();
				System.out.println("Entre com os dados do produto : ");
				System.out.print("Nome: ");
				String name = sc.nextLine();

				System.out.print("Preço: ");
				double price = sc.nextDouble();
				sc.nextLine();
				Product newProduct = new Product(name, price);

				System.out.print("Quantidade no estoque: ");
				int quantity = sc.nextInt();
				sc.nextLine();
				newProduct.addProducts(quantity);

				list.add(newProduct);
				System.out.println();
				System.out.println("Produto adicionado com sucesso!");
				System.out.println();
				break;

			case "2":
				System.out.println();
				System.out.print("Digite o nome do produto: ");
				String productName = sc.nextLine();
				boolean productFound = false;

				for (Product product : list) {
					if (product.getName().equalsIgnoreCase(productName)) {
						System.out.print("Digite a quantidade a ser adicionada: ");
						quantity = sc.nextInt();
						sc.nextLine();
						product.addProducts(quantity);
						System.out.println("Quantidade adicionada com sucesso.");
						Product.clearScreen();
						productFound = true;
						break;
					}
				}

				if (!productFound) {
					System.out.println();
					System.out.println("Produto não encontrado.");
				}
				break;

			case "3":
				System.out.println();
				System.out.print("Digite o nome do produto: ");
				productName = sc.nextLine();
				productFound = false;

				for (Product product : list) {
					if (product.getName().equalsIgnoreCase(productName)) {
						System.out.print("Digite a quantidade a ser retirada: ");
						quantity = sc.nextInt();
						sc.nextLine();
						product.removeProducts(quantity);
						System.out.println("Quantidade retirada com sucesso.");
						Product.clearScreen();
						productFound = true;
						break;
					}
				}

				if (!productFound) {
					System.out.println();
					System.out.println("Produto não encontrado.");
				}
				break;

			case "4":
				System.out.println();
				System.out.print("Digite o nome do produto que deseja excluir: ");
				productName = sc.nextLine();

				Product removeProducts = null;

				for (Product product : list) {
					if (product.getName().equalsIgnoreCase(productName)) {
						removeProducts = product;
						break;
					}
				}

				if (removeProducts != null) {
					list.remove(removeProducts);
					System.out.println();
					System.out.println("Produto removido com sucesso!");
					Product.clearScreen();
				} else {
					System.out.println();
					System.out.println("Produto não encontrado.");
				}
				break;

			case "5":
				System.out.println();
				System.out.println("Lista de Produtos:");
				for (Product product : list) {
					System.out.println(product);
				}
				break;

			case "sair":
				break;

			default:
				System.out.println();
				System.out.println("Opção inválida. Por favor, insira uma opção válida: ");
				break;
			}
		}
		
		System.out.println();
		System.out.println("Sistema finalizado com sucesso.");

		sc.close();
	}

}
