SensorCoverage = {
	doc title: "SensorCoverage",
		desc:  "Coverage at a small RNA sensor construct.",
		author: "António Domingues"

	output.dir = SENSOR_COVERAGE_OUTDIR

	transform(".bam") to(".plus.cov", ".minus.cov") {
		exec """

			${PREPARE_BEDTOOLS} &&

			${RUN_BEDTOOLS} genomecov -ibam $input -d -strand "+" | grep "21U_mCherry_sensor" > $output1 &&
			${RUN_BEDTOOLS} genomecov -ibam $input -d -strand "-" | grep "21U_mCherry_sensor" > $output2

		""","SensorCoverage"
	}
}

