<script>
  import { Header, Content, Grid, Row, Column, Button, Tile } from "carbon-components-svelte";
  import Launch from "carbon-icons-svelte/lib/Launch.svelte";
</script>

<Header companyName="IBM" platformName="Yarn & Carbon System" />

<Content>
  <Grid>
    <Row>
      <Column lg={16}>
        <Tile style="margin-top: 2rem;">
          <h2>Project Successfully Bootstrapped</h2>
          <p style="margin: 1rem 0;">Running securely via Yarn package manager.</p>
          <Button icon={Launch} href="https://carbondesignsystem.com" target="_blank">
            Explore Documentation
          </Button>
        </Tile>
      </Column>
    </Row>
  </Grid>
</Content>
