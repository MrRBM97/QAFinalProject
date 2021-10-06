package com.mrrbm.medicine_qaproject.medicine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Medicine</h1>
 * <h4>This class is the main entity to create Medicine Objects that can then be
 * used within the medicine database and API functionality.</h4>
 * <p>
 * The Medicine Class implement the standardised Builder Pattern. To create a
 * Medicine Object you use the {@link lombok.Builder} method. A Medicine is only
 * required to have a common name.
 * </p>
 * 
 * @author Ross Martin (MrRBM).
 *
 */

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Medicine {
	
	/**
	 * <h4>{@link Long} {@code id} - is automatically generated on an auto
	 * incremental basis.</h4>
	 * <p>
	 * <code>id</code> cannot be set through the Builder process, nor can it be set
	 * through the usual getters and setter.(getId is still available).
	 * </p>
	 * <p>
	 * Not initialised, cannot be null.
	 * </p>
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * <h4>{@link String} {@code commonName}- the name by which the medicine is
	 * commonly known.</h4>
	 * <p>
	 * An example of a {@code commonName} is {@code "Paracetamol"}.
	 * </p>
	 * <p>
	 * Not initised, cannot be null.
	 * </p>
	 */
	private String commonName;

	/**
	 * <h4>{@link String} {@code iupacName} - the IUPAC name of the chemical.</h4>
	 * <p>
	 * IUPAC stands for the International Union of Pure and Applied Chemistry. <br>
	 * An example of a {@code iupacName} is {@code "N-(4-hydroxyphenyl)acetamide"} -
	 * otherwise known as paracetamol.
	 * </p>
	 * <p>
	 * Initialised with the value null.
	 * </p>
	 */
	@Builder.Default
	private String iupacName = null;

	/**
	 * <h4>{@link String) {@code chmicalFormula} - the atomic formula of the
	 * chemical.</h4>
	 * <p>
	 * An example of a {@code chemcialFormula} is {@code "C8H9NO2"}, otherwise known
	 * a paracetamol.
	 * </p>
	 * <p>
	 * Initialised with the value null.
	 * </p>
	 */
	@Builder.Default
	private String chemicalFormula = null;

	/**
	 * <h4>{@link Double} {@code molecularWeight} - weight of the molecule in grams
	 * per mole in standard form (150.16).</h4>
	 * <p>
	 * An example of a {@code molecularWeight} is {@code 150.16}, which is the
	 * {@code molecularWeight} of paracetamol.
	 * </p>
	 * <p>
	 * Initialised with the value null.
	 * </p>
	 */
	@Builder.Default
	private Double molecularWeight = null;

	/**
	 * <h4>{@link Boolean} {@code isApprovedByMhra} - is the Medicine approved by
	 * the Medicines and Healthcare products Regulatory Agency.</h4>
	 * <p>
	 * {@code isApprovedByMhra} is either {@code true} or {@code false}, using
	 * Paracetamol as an example, {@code isApprovedByMhra} is {@code true}.
	 * </p>
	 * <p>
	 * Initialised with the value null.
	 * </p>
	 */
	@Builder.Default
	private Boolean isApprovedByMhra = null;

	/**
	 * <h4>{@link Boolean} {@code isControlledDrug} - is the medicine on the
	 * controlled drugs list.</h4>
	 * <p>
	 * {@code isControlledDrug} is either {@code true} or {@code false}, using
	 * Paracetamol as an example, {@code isControlledDrug} is {@code false}.
	 * </p>
	 * <p>
	 * Initialised with the value null.
	 * </p>
	 */
	@Builder.Default
	private Boolean isControlledDrug = null;

	/**
	 * <h4>{@link Boolean} {@code minStoreTemp} - the temperature by which the
	 * Medicine should not go below in celsius.</h4>
	 * <p>
	 * For example Paracetamol will remain as {@code null}, becasue Paracetamol has
	 * not published minimum storage temperature.
	 * </p>
	 * <p>
	 * Initialised with the value null.
	 * </p>
	 */
	@Builder.Default
	private Float minStoreTemp = null;

	/**
	 * <h4>{@link Boolean} {@code maxStoreTemp} - the temperature by which the
	 * Medicine should not go above in celsius.</h4>
	 * <p>
	 * For example, Paracetamol has a recommended maximum storage temperature of
	 * 25C, therefore {@code maxStoreTemp} would be {@code 25}.
	 * </p>
	 * <p>
	 * Initialised with the value null.
	 * </p>
	 */
	@Builder.Default
	private Float maxStoreTemp = null;
}